package neuralnetwork;

import core.Input;
import core.Output;
import core.PredictionModel;

public class NeuralNetwork implements PredictionModel{
	private Layer _layers[];
	private int _layersNum;
	//private int _layersStructure[];
	private double _inputs[];
	private double _outputs[];
	

	public double[] getInputs() {
		return _inputs;
	}

	public void setInputs(double[] inputs) {
		//if(inputs.length != this._layersStructure[0]) throw new RuntimeException("Inputs num and first layer neurons num must be equal");
		_inputs = inputs;
	}

	public double[] getOutputs() {
		return _outputs;
	}

	public void setOutputs(double[] outputs) {
		_outputs = outputs;
	}

	public int getLayersNum() {
		return _layersNum;
	}

	public void setLayersNum(int layersNum) {
		_layersNum = layersNum;
	}

	public NeuralNetwork(int layersNum, int layersStructure[], ActivationFunction functionStructure[]) {
		super();
		if(layersNum < 2) throw new RuntimeException("Unable to create a network with less than 2 layers");
		if(layersNum != layersStructure.length || layersNum != functionStructure.length) throw new RuntimeException("Layer structure size and layer num are not equal.");
		
		_layersNum = layersNum;
		_layers = new Layer[_layersNum];
		//_layersStructure = layersStructure;
		/**
		 * input layer does nothing
		 */
		_layers[0] = new Layer(layersStructure[0], 1, null){
			@Override
			public void execute(){
				this._outputs = this._inputs;
			}
		};
		
		for(int i = 1; i < _layersNum; i++)
			_layers[i] = new Layer(layersStructure[i], layersStructure[i - 1], functionStructure[i]);
	}

	public void execute(){
		if(this._inputs == null) throw new RuntimeException("Specify inputs for a network");
		double inputs[] = this._inputs;
		double outputs[] = this._inputs;
		/**
		 * each layer executes inputs as an output of previous layer
		 */
		for(int i=0; i< this._layersNum; i++){
			inputs = outputs;
			this._layers[i].setInputs(inputs);
			this._layers[i].execute();
			outputs = this._layers[i].getOutputs();
		}
		this._outputs = outputs;
	}
	/**
	 * return copy of weights for all layers
	 * @return
	 */
	public double [][][] getWeightsC(){
		double weights[][][] = new double[_layersNum][][];
		for(int li = 0; li < _layersNum; li++){
			weights[li] = _layers[li].getWeightsC();
		}
		return weights;
	}
	/**
	 * refresh all weights
	 * @param _weights
	 */
	public void reload(double _weights[][][]){
		if(_weights.length != _layersNum) 
			throw new RuntimeException("Relodaing weights' array size is not equal the native size");
		for(int li = 0; li < _layersNum; li++){
			int neuronsNum = _weights[li].length;
			int inputsNum = _weights[li][0].length;
			if(_layers[li]._inputsNum != inputsNum || _layers[li]._inputsNum != neuronsNum)  
				throw new RuntimeException("Relodaing weights' array size is not equal the native size");
			_layers[li].reload(_weights[li]);
		}
	}

	@Override
	public Output process(Input _input) {
		// TODO Auto-generated method stub
		return null;
	}
}
