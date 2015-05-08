package edu.wpi.grip.core;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {
    EventBus eventBus = new EventBus();
    Operation addition = new AdditionOperation();

    @Test
    public void testOperation() throws Exception {
        Socket[] inputs = addition.createInputSockets(eventBus);
        Socket[] outputs = addition.createOutputSockets(eventBus);
        Socket<Double> a = inputs[0], b = inputs[1], c = outputs[0];

        a.setValue(1234.0);
        b.setValue(5678.0);
        addition.perform(inputs, outputs);

        assertEquals((Double) (1234.0 + 5678.0), c.getValue());
    }
}
