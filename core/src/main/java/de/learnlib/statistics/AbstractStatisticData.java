/* Copyright (C) 2013-2017 TU Dortmund
 * This file is part of LearnLib, http://www.learnlib.de/.
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

package de.learnlib.statistics;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Common interface for statistical data.
 *
 * @author falkhowar
 */
@ParametersAreNonnullByDefault
public abstract class AbstractStatisticData {

    private final String name;
    private final String unit;

    protected AbstractStatisticData(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public String getUnit() {
        return unit;
    }

    @Nonnull
    public abstract String getSummary();

    @Nonnull
    public abstract String getDetails();
}