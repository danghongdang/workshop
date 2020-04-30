/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shardingsphere.workshop.parser.engine;

import org.junit.Test;
import shardingsphere.workshop.parser.statement.segment.AssignmentValueSegment;
import shardingsphere.workshop.parser.statement.segment.ColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnValueSegment;
import shardingsphere.workshop.parser.statement.statement.InsertStatement;
import shardingsphere.workshop.parser.statement.statement.SelectStatement;
import shardingsphere.workshop.parser.statement.statement.UpdateStatement;
import shardingsphere.workshop.parser.statement.statement.UseStatement;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class ParseEngineTest {
    
    @Test
    public void testParse() {
        String sql = "use sharding_db";
        UseStatement useStatement = (UseStatement) ParseEngine.parse(sql);
        assertThat(useStatement.getSchemeName().getIdentifier().getValue(), is("sharding_db"));
    }

    @Test
    public void testInsertParse() {
        String sql = "insert into table1 (c1, c2) value (1, 2)";
        InsertStatement insertStatement = (InsertStatement) ParseEngine.parse(sql);
        assertThat(insertStatement.getTableNameSegment().getIdentifier().getValue(), is("table1"));
        int i = 1;
        for (ColumnNameSegment columnNameSegment : insertStatement.getColumnNamesSegment().getColumnNameSegmentList()) {
            assertThat(columnNameSegment.getIdentifier().getValue(), is("c" + i));
            i++;
        }
        int j = 1;
        for (AssignmentValueSegment assignmentValueSegment : insertStatement.getAssignmentValuesSegment().getAssignmentValueSegments()) {
            assertThat(assignmentValueSegment.getIdentifier().getValue(), is( "" + j));
            j++;
        }
    }

    @Test
    public void testSelectAllParse() {
        String sql = "select * from table1 where c1 = 1 and c2 = 2";
        SelectStatement selectStatement = (SelectStatement) ParseEngine.parse(sql);
        assertThat(selectStatement.getTableNameSegment().getIdentifier().getValue(), is("table1"));
        for (ColumnNameSegment columnNameSegment : selectStatement.getSelectColumnNamesSegment().getColumnNameSegmentList()) {
            assertThat(columnNameSegment.getIdentifier().getValue(), is("*"));
        }
        int i = 1;
        for (WhereColumnNameSegment whereColumnNameSegment : selectStatement.getWhereColumnNameAndValuesSegment().getWhereColumnNameSegmentList()) {
            assertThat(whereColumnNameSegment.getIdentifier().getValue(), is("c"+i));
            i++;
        }
        int j = 1;
        for (WhereColumnValueSegment whereColumnValueSegment : selectStatement.getWhereColumnNameAndValuesSegment().getWhereColumnValueSegmentList()) {
            assertThat(whereColumnValueSegment.getIdentifier().getValue(), is(j + ""));
            j++;
        }
    }

    @Test
    public void testSelectColumnParse() {
        String sql = "select c1 from table1 where c2 = 2";
        SelectStatement selectStatement = (SelectStatement) ParseEngine.parse(sql);
        assertThat(selectStatement.getTableNameSegment().getIdentifier().getValue(), is("table1"));
        for (ColumnNameSegment columnNameSegment : selectStatement.getSelectColumnNamesSegment().getColumnNameSegmentList()) {
            assertThat(columnNameSegment.getIdentifier().getValue(), is("c1"));
        }
        for (WhereColumnNameSegment whereColumnNameSegment : selectStatement.getWhereColumnNameAndValuesSegment().getWhereColumnNameSegmentList()) {
            assertThat(whereColumnNameSegment.getIdentifier().getValue(), is("c2"));
        }
        for (WhereColumnValueSegment whereColumnValueSegment : selectStatement.getWhereColumnNameAndValuesSegment().getWhereColumnValueSegmentList()) {
            assertThat(whereColumnValueSegment.getIdentifier().getValue(), is("2"));
        }
    }

    @Test
    public void updateColumnParse() {
        String sql = "update table1 set c1 = 2 where c2 = 2";
        UpdateStatement updateStatement = (UpdateStatement) ParseEngine.parse(sql);
        assertThat(updateStatement.getTableNameSegment().getIdentifier().getValue(), is("table1"));
        for (ColumnNameSegment columnNameSegment : updateStatement.getUpdateColumnNameAndValuesSegment().getColumnNameSegmentList()) {
            assertThat(columnNameSegment.getIdentifier().getValue(), is("c1"));
        }
        for (WhereColumnNameSegment whereColumnNameSegment : updateStatement.getWhereColumnNameAndValuesSegment().getWhereColumnNameSegmentList()) {
            assertThat(whereColumnNameSegment.getIdentifier().getValue(), is("c2"));
        }
        for (WhereColumnValueSegment whereColumnValueSegment : updateStatement.getWhereColumnNameAndValuesSegment().getWhereColumnValueSegmentList()) {
            assertThat(whereColumnValueSegment.getIdentifier().getValue(), is("2"));
        }
    }
}
