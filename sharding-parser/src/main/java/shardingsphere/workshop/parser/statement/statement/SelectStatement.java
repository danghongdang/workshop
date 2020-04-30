package shardingsphere.workshop.parser.statement.statement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.SelectColumnNamesSegment;
import shardingsphere.workshop.parser.statement.segment.TableNameSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnNameAndValuesSegment;

@RequiredArgsConstructor
@Getter
public class SelectStatement implements ASTNode {

    private final SelectColumnNamesSegment selectColumnNamesSegment;

    private final TableNameSegment tableNameSegment;

    private final WhereColumnNameAndValuesSegment whereColumnNameAndValuesSegment;
}
