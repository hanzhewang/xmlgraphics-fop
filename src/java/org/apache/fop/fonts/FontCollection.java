/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.fonts;


/**
 * Sets up a set of fonts
 */
public interface FontCollection {
    /**
     * Sets up fonts in a font info object.
     *
     * Adds metrics for basic fonts and useful family-style-weight
     * triplets for lookup.
     *
     * @param start the font starting number
     * @param fontInfo the font info to set up
     * @return the starting font number for the next font to be added
     */
    int setup(int start, FontInfo fontInfo);
}
