package pl.sda.commons.strategy;

@FunctionalInterface
public interface Convertable {

    boolean convert(Object object);
}
