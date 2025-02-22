package main.model.request;

public enum RequestStatus 
{
    APPROVED,

    DENIED,

    PENDING;

    public String colorStatus() {
        return switch (this) {
            case APPROVED -> "\u001B[32m" + this + "\u001B[0m"; // green
            case DENIED -> "\u001B[31m" + this + "\u001B[0m"; // red
            case PENDING -> "\u001B[34m" + this + "\u001B[0m"; // blue
        };
    }
}
