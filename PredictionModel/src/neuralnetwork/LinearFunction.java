package neuralnetwork;

public class LinearFunction implements ActivationFunction{

	@Override
	public double compute(double _value) {
		return _value;
	}

	@Override
	public double derivative(double _value) {
		return 1;
	}

}
