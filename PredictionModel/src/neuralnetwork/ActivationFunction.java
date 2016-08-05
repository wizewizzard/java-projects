package neuralnetwork;

public interface ActivationFunction {
	public double compute(double _value);
	public double derivative(double _value);
}
