package structural.adapter.javarush;

public record CardReader(MemoryCard memoryCard) implements USB {

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
    }
}
