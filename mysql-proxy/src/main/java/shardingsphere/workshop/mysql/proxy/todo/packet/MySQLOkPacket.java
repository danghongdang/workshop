package shardingsphere.workshop.mysql.proxy.todo.packet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.mysql.proxy.fixture.packet.MySQLPacket;
import shardingsphere.workshop.mysql.proxy.fixture.packet.MySQLPacketPayload;
import shardingsphere.workshop.mysql.proxy.fixture.packet.constant.MySQLStatusFlag;

@RequiredArgsConstructor
@Getter
public class MySQLOkPacket implements MySQLPacket {

    public static final int HEADER = 0x00;

    private final int sequenceId;

    private final int affectedRows;

    private final int lastInsertId;

    public MySQLOkPacket(final int sequenceId) {
        this(sequenceId, 0, MySQLStatusFlag.SERVER_STATUS_AUTOCOMMIT.getValue());
    }

    @Override
    public void write(MySQLPacketPayload payload) {
        payload.writeInt1(HEADER);
        payload.writeInt2(affectedRows);
        payload.writeInt2(lastInsertId);
    }
}
