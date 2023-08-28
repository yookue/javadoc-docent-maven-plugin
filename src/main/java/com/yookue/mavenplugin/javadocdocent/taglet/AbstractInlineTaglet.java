/*
 * Copyright (c) 2021 Yookue Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yookue.mavenplugin.javadocdocent.taglet;


import javax.annotation.Nullable;
import com.sun.javadoc.Tag;


/**
 * An abstract taglet that representing inline tags
 *
 * @author David Hsing
 */
public abstract class AbstractInlineTaglet extends AbstractBaseTaglet {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isInlineTag() {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * This method should not be called since arrays of inline tags do not exist
     */
    @Override
    public String toString(@Nullable Tag[] tags) {
        return null;
    }
}
