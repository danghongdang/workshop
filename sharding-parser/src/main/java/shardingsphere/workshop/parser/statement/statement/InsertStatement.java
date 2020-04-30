package shardingsphere.workshop.parser.statement.statement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.AssignmentValuesSegment;
import shardingsphere.workshop.parser.statement.segment.ColumnNamesSegment;
import shardingsphere.workshop.parser.statement.segment.TableNameSegment;

@RequiredArgsConstructor
@Getter
public class InsertStatement implements ASTNode {

    private final TableNameSegment tableNameSegment;

    private final ColumnNamesSegment columnNamesSegment;

    private final AssignmentValuesSegment assignmentValuesSegment;
}
