/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.wikimodel.mediawiki;

import java.io.Reader;

import org.xwiki.rendering.wikimodel.IWemListener;
import org.xwiki.rendering.wikimodel.IWikiParser;
import org.xwiki.rendering.wikimodel.WikiParserException;
import org.xwiki.rendering.wikimodel.impl.WikiScannerContext;
import org.xwiki.rendering.wikimodel.internal.mediawiki.javacc.MediawikiScanner;
import org.xwiki.rendering.wikimodel.internal.mediawiki.javacc.ParseException;

/**
 * @version $Id: e9a8f1cd36595afcf7966f25982b816acc559316 $
 * @since 4.0M1
 */
public class MediaWikiParser implements IWikiParser
{
    /**
     *
     */
    public MediaWikiParser()
    {
        super();
    }

    /**
     * @see org.xwiki.rendering.wikimodel.IWikiParser#parse(java.io.Reader,
     *      org.xwiki.rendering.wikimodel.IWemListener)
     */
    public void parse(Reader reader, IWemListener listener)
        throws WikiParserException
    {
        try {
            MediawikiScanner scanner = new MediawikiScanner(reader);
            WikiScannerContext context = new WikiScannerContext(listener);
            scanner.parse(context);
        } catch (ParseException e) {
            throw new WikiParserException(e);
        }
    }
}
