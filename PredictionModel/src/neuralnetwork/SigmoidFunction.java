package neuralnetwork;

public class SigmoidFunction implements ActivationFunction{

	@Override
	public double compute(double _value) {
		return  1 / ( 1 + Math.pow(Math.E,  -_value ));
	}

	@Override
	public double derivative(double _value) {
		return this.compute(_value)*(1 - this.compute(_value));
	}

}
