package shardingsphere.workshop.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;

@RequiredArgsConstructor
@Getter
public class UpdateColumnValueSegment implements ASTNode {

    private final IdentifierSegment identifier;
}
