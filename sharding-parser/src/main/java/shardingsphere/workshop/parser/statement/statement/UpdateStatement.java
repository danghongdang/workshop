package shardingsphere.workshop.parser.statement.statement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.TableNameSegment;
import shardingsphere.workshop.parser.statement.segment.UpdateColumnNameAndValuesSegment;
import shardingsphere.workshop.parser.statement.segment.WhereColumnNameAndValuesSegment;

@RequiredArgsConstructor
@Getter
public class UpdateStatement implements ASTNode {

    private final TableNameSegment tableNameSegment;

    private final UpdateColumnNameAndValuesSegment updateColumnNameAndValuesSegment;

    private final WhereColumnNameAndValuesSegment whereColumnNameAndValuesSegment;
}
