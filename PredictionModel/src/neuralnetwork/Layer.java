package neuralnetwork;

import java.util.Arrays;
import java.util.Random;

public class Layer {
	protected int _neuronsNum;
	protected int _inputsNum;
	protected double _weights[][];
	protected double _inputs[];
	protected double _outputs[];
	protected double _offsets[][];
	protected ActivationFunction _acivationFunction;
	
	public int getNeuronsNum() {
		return _neuronsNum;
	}
	public void setNeuronsNum(int neuronsNum) {
		_neuronsNum = neuronsNum;
	}
	public int getInputsNum() {
		return _inputsNum;
	}
	public void setInputsNum(int inputsNum) {
		_inputsNum = inputsNum;
	}
	public double[][] getWeights() {
		return _weights;
	}
	public void setWeights(double[][] weights) {
		_weights = weights;
	}
	public double[] getInputs() {
		return _inputs;
	}
	public void setInputs(double[] inputs) {
		_inputs = inputs;
	}
	public double[] getOutputs() {
		return _outputs;
	}
	public Layer(int neuronsNum, int inputsNum, ActivationFunction acivationFunction) {
		super();
		_neuronsNum = neuronsNum;
		_inputsNum = inputsNum;
		_acivationFunction = acivationFunction;
		/**
		 * matrix of weights inputsNum (w) x neuronsNum (h)
		 */
		this._weights = new double[_inputsNum][_neuronsNum];
		this._outputs = new double[_neuronsNum];
		this.randomWeights(-1, 1);
	}
	public Layer(int neuronsNum, int inputsNum, ActivationFunction acivationFunction, double _defaultWeight) {
		super();
		_neuronsNum = neuronsNum;
		_inputsNum = inputsNum;
		_acivationFunction = acivationFunction;
		/**
		 * matrix of weights inputsNum (w) x neuronsNum (h)
		 */
		this._weights = new double[_inputsNum][_neuronsNum];
		this._outputs = new double[_neuronsNum];
		for (int ni = 0; ni < _neuronsNum; ni++){
			for (int ii = 0; ii < _inputsNum; ii++) {
            	 this._weights[ii][ni] = _defaultWeight;
            }
        }
	}
	
	public void execute(){
		/**
		 * weights x inputs => output for each neuron
		 */
		for (int ni = 0; ni < _neuronsNum; ni++){
			for (int ii = 0; ii < _inputsNum; ii++) {
            	this._outputs[ni] += this._weights[ii][ni] * this._inputs[ii];
			}
			this._outputs[ni] = this._acivationFunction.compute(this._outputs[ni]);
		}

	}
	
	public void randomWeights(double _lowRange, double _upRange){
		Random r = new Random();
		for (int ni = 0; ni < _neuronsNum; ni++){
			for (int ii = 0; ii < _inputsNum; ii++) {
            	 this._weights[ii][ni] = _lowRange + (_upRange - _lowRange) * r.nextDouble();
            }
        }
	}
	
	public void reload(double _weights[][]){
		for (int ni = 0; ni < _neuronsNum; ni++){
			for (int ii = 0; ii < _inputsNum; ii++) {
            	 this._weights[ii][ni] = _weights[ii][ni];
            }
        }
	}
	/**
	 * return copy of weights array
	 * @return
	 */
	public double[][] getWeightsC(){
		double cweights[][] = new double[_inputsNum][_neuronsNum];
		for (int ni = 0; ni < _neuronsNum; ni++){
			for (int ii = 0; ii < _inputsNum; ii++) {
            	cweights[ii][ni] = _weights[ii][ni];
            }
        }
		return cweights;
	}
	
}
