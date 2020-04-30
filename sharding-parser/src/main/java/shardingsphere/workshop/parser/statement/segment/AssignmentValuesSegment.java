package shardingsphere.workshop.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class AssignmentValuesSegment implements ASTNode {

    private final List<AssignmentValueSegment> assignmentValueSegments;
}
