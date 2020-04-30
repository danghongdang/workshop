
package shardingsphere.workshop.parser.engine.visitor;

import autogen.MySQLStatementBaseVisitor;
import autogen.MySQLStatementParser;
import autogen.MySQLStatementParser.IdentifierContext;
import autogen.MySQLStatementParser.SchemaNameContext;
import autogen.MySQLStatementParser.UseContext;
import com.google.common.collect.Lists;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.*;
import shardingsphere.workshop.parser.statement.statement.InsertStatement;
import shardingsphere.workshop.parser.statement.statement.SelectStatement;
import shardingsphere.workshop.parser.statement.statement.UpdateStatement;
import shardingsphere.workshop.parser.statement.statement.UseStatement;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * MySQL visitor.
 */
public final class SQLVisitor extends MySQLStatementBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitUse(final UseContext ctx) {
        SchemeNameSegment schemeName = (SchemeNameSegment) visit(ctx.schemaName());
        return new UseStatement(schemeName);
    }

    @Override
    public ASTNode visitSchemaName(final SchemaNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new SchemeNameSegment(identifier);
    }

    @Override
    public ASTNode visitIdentifier(final IdentifierContext ctx) {
        return new IdentifierSegment(ctx.getText());
    }

    @Override
    public ASTNode visitInsert(final MySQLStatementParser.InsertContext ctx) {
        TableNameSegment tableNameSegment = (TableNameSegment) visit(ctx.tableName());
        ColumnNamesSegment columnNamesSegment = (ColumnNamesSegment) visit(ctx.columnNames());
        MySQLStatementParser.AssignmentValuesContext assignmentValuesContext = ctx.assignmentValues();
        AssignmentValuesSegment assignmentValuesSegment;
        if (assignmentValuesContext != null) {
            assignmentValuesSegment = (AssignmentValuesSegment) visit(assignmentValuesContext);
        } else {
            assignmentValuesSegment = new AssignmentValuesSegment(Collections.emptyList());
        }
        return new InsertStatement(tableNameSegment, columnNamesSegment, assignmentValuesSegment);
    }

    @Override
    public ASTNode visitTableName(final MySQLStatementParser.TableNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new TableNameSegment(identifier);
    }

    @Override
    public ASTNode visitColumnNames(final MySQLStatementParser.ColumnNamesContext ctx) {
        List<ColumnNameSegment> list = Lists.newArrayList();
        for (MySQLStatementParser.ColumnNameContext columnNameContext : ctx.columnName()) {
            list.add((ColumnNameSegment) visit(columnNameContext));
        }
        return new ColumnNamesSegment(list);
    }

    @Override
    public ASTNode visitColumnName(final MySQLStatementParser.ColumnNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new ColumnNameSegment(identifier);
    }

    @Override
    public ASTNode visitAssignmentValues(final MySQLStatementParser.AssignmentValuesContext ctx) {
        List<AssignmentValueSegment> list = Lists.newArrayList();
        for (MySQLStatementParser.AssignmentValueContext assignmentValueContext : ctx.assignmentValue()) {
            list.add((AssignmentValueSegment) visit(assignmentValueContext));
        }
        return new AssignmentValuesSegment(list);
    }

    @Override
    public ASTNode visitAssignmentValue(final MySQLStatementParser.AssignmentValueContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new AssignmentValueSegment(identifier);
    }

    @Override
    public ASTNode visitSelect(MySQLStatementParser.SelectContext ctx) {
        SelectColumnNamesSegment selectColumnNamesSegment = (SelectColumnNamesSegment) visit(ctx.selectColumnNames());
        TableNameSegment tableNameSegment = (TableNameSegment) visit(ctx.tableName());
        MySQLStatementParser.WhereColumnNameAndValuesContext columnNameAndValuesContext = ctx.whereColumnNameAndValues();
        WhereColumnNameAndValuesSegment whereColumnNameAndValuesSegment;
        if (columnNameAndValuesContext != null) {
            whereColumnNameAndValuesSegment = (WhereColumnNameAndValuesSegment) visit(columnNameAndValuesContext);
        } else {
            whereColumnNameAndValuesSegment = new WhereColumnNameAndValuesSegment(Collections.emptyList(), Collections.emptyList());
        }
        return new SelectStatement(selectColumnNamesSegment, tableNameSegment, whereColumnNameAndValuesSegment);
    }

    @Override
    public ASTNode visitSelectColumnNames(MySQLStatementParser.SelectColumnNamesContext ctx) {
        List<ColumnNameSegment> list = Lists.newArrayList();
        for (MySQLStatementParser.ColumnNameContext columnNameContext : ctx.columnName()) {
            list.add((ColumnNameSegment) visit(columnNameContext));
        }
        return new SelectColumnNamesSegment(list);
    }

    @Override
    public ASTNode visitWhereColumnNameAndValues(MySQLStatementParser.WhereColumnNameAndValuesContext ctx) {
        List<WhereColumnNameSegment> nameList = Lists.newArrayList();
        for (MySQLStatementParser.WhereColumnNameContext nameContext : ctx.whereColumnName()) {
            nameList.add((WhereColumnNameSegment) visit(nameContext));
        }
        List<WhereColumnValueSegment> valueList = Lists.newArrayList();
        for (MySQLStatementParser.WhereColumnValueContext valueContext : ctx.whereColumnValue()) {
            valueList.add((WhereColumnValueSegment) visit(valueContext));
        }
        return new WhereColumnNameAndValuesSegment(nameList, valueList);
    }

    @Override
    public ASTNode visitWhereColumnName(MySQLStatementParser.WhereColumnNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new WhereColumnNameSegment(identifier);
    }

    @Override
    public ASTNode visitWhereColumnValue(MySQLStatementParser.WhereColumnValueContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new WhereColumnValueSegment(identifier);
    }

    @Override
    public ASTNode visitUpdate(MySQLStatementParser.UpdateContext ctx) {
        TableNameSegment tableNameSegment = (TableNameSegment) visit(ctx.tableName());
        UpdateColumnNameAndValuesSegment updateColumnNameAndValuesSegment = (UpdateColumnNameAndValuesSegment) visit(ctx.updateColumnNameAndValues());
        WhereColumnNameAndValuesSegment whereColumnNameAndValuesSegment;
        if (ctx.whereColumnNameAndValues() != null) {
            whereColumnNameAndValuesSegment = (WhereColumnNameAndValuesSegment) visit(ctx.whereColumnNameAndValues());
        } else {
            whereColumnNameAndValuesSegment = new WhereColumnNameAndValuesSegment(Collections.emptyList(), Collections.emptyList());
        }
        return new UpdateStatement(tableNameSegment, updateColumnNameAndValuesSegment, whereColumnNameAndValuesSegment);
    }

    @Override
    public ASTNode visitUpdateColumnNameAndValues(MySQLStatementParser.UpdateColumnNameAndValuesContext ctx) {
        List<ColumnNameSegment> columnNameSegmentList = Lists.newArrayList();
        for (MySQLStatementParser.ColumnNameContext columnNameContext : ctx.columnName()) {
            columnNameSegmentList.add((ColumnNameSegment) visit(columnNameContext));
        }
        List<UpdateColumnValueSegment> updateColumnValueSegmentList = Lists.newArrayList();
        for (MySQLStatementParser.UpdateColumnValueContext updateColumnValueContext : ctx.updateColumnValue()) {
            updateColumnValueSegmentList.add((UpdateColumnValueSegment) visit(updateColumnValueContext));
        }
        return new UpdateColumnNameAndValuesSegment(columnNameSegmentList, updateColumnValueSegmentList);
    }

    @Override
    public ASTNode visitUpdateColumnValue(MySQLStatementParser.UpdateColumnValueContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new UpdateColumnValueSegment(identifier);
    }
}
