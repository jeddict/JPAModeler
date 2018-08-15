/*
 * Copyright (C) 2016-2018 The JavaParser Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.jeddict.source;

import com.github.javaparser.resolution.declarations.ResolvedReferenceTypeDeclaration;
import com.github.javaparser.symbolsolver.model.resolution.SymbolReference;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.reflectionmodel.ReflectionFactory;
import java.util.Optional;

public class ClassloaderTypeSolver implements TypeSolver {

    private TypeSolver parent;

    private ClassLoader classLoader;

    public ClassloaderTypeSolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public TypeSolver getParent() {
        return parent;
    }

    @Override
    public void setParent(TypeSolver parent) {
        this.parent = parent;
    }

    @Override
    public SymbolReference<ResolvedReferenceTypeDeclaration> tryToSolveType(String name) {
        try {
            // Some implementations could return null when the class was loaded through the bootstrap classloader
                // see https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getClassLoader--
                if (classLoader == null) {
                    throw new RuntimeException("The ClassloaderTypeSolver has been probably loaded through the bootstrap class loader. This usage is not supported by the JavaSymbolSolver");
                }

                Class<?> clazz = classLoader.loadClass(name);
                return SymbolReference.solved(ReflectionFactory.typeDeclarationFor(clazz, getRoot()));
            } catch (ClassNotFoundException e) {
                // it could be an inner class
                int lastDot = name.lastIndexOf('.');
                if (lastDot == -1) {
                    return SymbolReference.unsolved(ResolvedReferenceTypeDeclaration.class);
                } else {
                    String parentName = name.substring(0, lastDot);
                    String childName = name.substring(lastDot + 1);
                    SymbolReference<ResolvedReferenceTypeDeclaration> parent = tryToSolveType(parentName);
                    if (parent.isSolved()) {
                        Optional<ResolvedReferenceTypeDeclaration> innerClass = parent.getCorrespondingDeclaration().internalTypes()
                                .stream().filter(it -> it.getName().equals(childName)).findFirst();
                        if (innerClass.isPresent()) {
                            return SymbolReference.solved(innerClass.get());
                        } else {
                            return SymbolReference.unsolved(ResolvedReferenceTypeDeclaration.class);
                        }
                    } else {
                        return SymbolReference.unsolved(ResolvedReferenceTypeDeclaration.class);
                    }
                }
            }
    }

}