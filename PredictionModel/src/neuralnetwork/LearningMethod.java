package neuralnetwork;

public interface LearningMethod {
	public void getLearningSample();
	public void learnNetwork(NeuralNetwork _nn);
}
