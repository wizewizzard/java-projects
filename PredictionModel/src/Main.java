import java.sql.SQLException;
import java.util.Arrays;

import core.DBConnector;
import neuralnetwork.ActivationFunction;
import neuralnetwork.LinearFunction;
import neuralnetwork.NeuralNetwork;
import neuralnetwork.SigmoidFunction;

public class Main {
	public static void main(String args[]){
		
		NeuralNetwork nn = new NeuralNetwork(3, new int[]{2, 5, 1}, new ActivationFunction[]{null, new LinearFunction(), new LinearFunction()});
		nn.setInputs(new double[]{1,5});
		nn.execute();
		System.out.println(Arrays.toString(nn.getOutputs()));
	}
}
