/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2020 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package io.questdb.griffin.model;

public class Interval {
    long lo;
    long hi;
    int count;
    char periodType;
    int period;

    public Interval of(long lo, long hi) {
        this.lo = lo;
        this.hi = hi;
        count = 1;
        this.period = 0;
        periodType = 0;
        return this;
    }

    public Interval of(long lo, long hi, int period, char periodType, int count) {
        this.lo = lo;
        this.hi = hi;
        this.count = count;
        this.period = period;
        this.periodType = periodType;
        return this;
    }
}