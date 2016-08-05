package neuralnetwork;

public class BipolarSigmoidFunction implements ActivationFunction{

	@Override
	public double compute(double _value) {
		return (2 / (1 + Math.pow(Math.E,  -_value )) - 1) ;
	}

	@Override
	public double derivative(double _value) {
		return (0.5 * (1 + this.compute( _value )) * (1 - this.compute( _value )));
	}

}
