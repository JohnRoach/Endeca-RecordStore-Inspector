/**
 * Copyright (c) 2015, Oracle Corporation
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 *     * Neither the name of Oracle nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL ORACLE BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.ateam.endeca.tools.rsi.export;

import com.endeca.itl.record.Record;
import com.endeca.itl.record.io.RecordIOFactory;
import com.endeca.itl.record.io.RecordWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * A export writer for Endeca Record XML files.
 *
 * @author Jim Prantzalos
 * @version 1.0
 * @since R1.0
 */
public class XmlExporter implements Exporter {
    private transient static final Logger log = LoggerFactory.getLogger(XmlExporter.class);
    private RecordWriter writer;

    public XmlExporter(File exportFile) {
        try {
            writer = RecordIOFactory.createRecordWriter(exportFile);
        } catch (IOException e) {
            log.error("Unable to create export file '" + exportFile + "'", e);
        }
    }

    @Override
    public void writeHeader(Map<String, Integer> columnIndexMap) throws IOException {
        // do nothing
    }

    @Override
    public void writeRecord(Record record) throws IOException {
        writer.write(record);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
