/*
 * Copyright (c) 2014-2015. Vlad Ilyushchenko
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

package com.nfsdb.lang.parser;

import com.nfsdb.collections.ObjObjHashMap;
import com.nfsdb.lang.ast.Signature;
import com.nfsdb.storage.ColumnType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SignatureTest {
    @Test
    public void testMapBehaviour() throws Exception {
        ObjObjHashMap<Signature, String> sigs = new ObjObjHashMap<Signature, String>() {{

            put(new Signature().setName("-").setParamCount(1).addParamType(ColumnType.INT), "sig1");
            // overload
            put(new Signature().setName("-").setParamCount(1).addParamType(ColumnType.DOUBLE), "sig2");
            // overload 2
            put(new Signature().setName("-").setParamCount(2).addParamType(ColumnType.INT).addParamType(ColumnType.INT), "sig3");
            // dupe
            put(new Signature().setName("-").setParamCount(1).addParamType(ColumnType.INT), "sig4");
        }};

        Assert.assertEquals(3, sigs.size());
        String[] expected = new String[]{"sig2", "sig3", "sig4"};
        String[] actual = new String[sigs.size()];

        int k = 0;
        for (ObjObjHashMap.Entry<Signature, String> e : sigs) {
            actual[k++] = e.value;
        }

        Arrays.sort(actual);
        Assert.assertArrayEquals(expected, actual);
    }
}
