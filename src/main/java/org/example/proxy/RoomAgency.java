package org.example.proxy;

public class RoomAgency implements IRoom {
    // 持有一个被代理人的引用
    private IRoom mRoom;

    public RoomAgency(IRoom room) {
        this.mRoom = room;
    }

    @Override
    public void seekRoom() {
        mRoom.seekRoom();
    }

    @Override
    public void watchRoom() {
        mRoom.watchRoom();
    }

    @Override
    public void room() {
        mRoom.room();
    }

    @Override
    public void finish() {
        mRoom.finish();
    }
}
