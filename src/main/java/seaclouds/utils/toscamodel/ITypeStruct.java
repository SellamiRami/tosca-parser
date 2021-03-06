/*
 * Copyright 2015 UniversitÓ di Pisa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package seaclouds.utils.toscamodel;

import java.util.Map;

/**
 * Created by pq on 19/03/2015.
 * Represents a complex type with its schema definition.
 */
public interface ITypeStruct extends ISchemaDefinition, IType {
    @Override
    ITypeStruct baseType();

    @Override
    IValueStruct instantiate(Object value);

    IValueStruct instantiate(Map<String,Object> value);

    @Override
    ITypeStruct addProperty(String propName, IType propType,Object defaultValue);

    @Override default
    boolean derivesFrom(IType parent) {
        return parent instanceof ITypeStruct && derivesFrom((ITypeStruct) parent);
    }

    @Override default
    boolean derivesFrom(ISchemaDefinition parent){
        return parent instanceof ITypeStruct && derivesFrom((ITypeStruct) parent);
    }

    boolean derivesFrom(ITypeStruct parent);
}
