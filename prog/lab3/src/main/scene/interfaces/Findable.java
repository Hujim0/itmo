package main.scene.interfaces;

import main.scene.nodes.Node;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public interface Findable {
    boolean compare(Node o1);
}
