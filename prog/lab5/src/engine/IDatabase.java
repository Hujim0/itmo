package engine;

import parser.types.generic.Serializable;

public interface IDatabase {

    public Serializable<?> getEntity();
}
