package neuralnetwork;

public class BackPropagationLearning implements LearningMethod {
	private double _learningRate = 0.05;
	@Override
	public void learnNetwork(NeuralNetwork _nn) {
		double weights[][][] = _nn.getWeightsC();
		double correctedWeights[][][] = _nn.getWeightsC();
		
		
	}
	@Override
	public void getLearningSample() {
		
	}
	/*
	private void runRecursive(int _curLayer, double _correctedWeights[][][], double _errorBuffer[]){
		if (_curLayer == 0) return;//input layer
        if (_curLayer == _correctedWeights.length - 1){//last layer
            double[] _layer_deltas = new double[_correctedWeights[_curLayer].length];
            for (int ni = 0; ni < _correctedWeights[_curLayer].length; ni++)
            {
                for (int ii = 0; ii < _correctedWeights[_curLayer][0].length; ii++)
                {
                    double delta_ni = 0.0;
                    _layer_deltas[ni] = delta_ni = _errorBuffer[ni] * Helper.functions_deriviate_out[m_layers[_curLayer].Transfer_function](m_layers_outputs[_curLayer][ni]);
                    _correctedWeights[_curLayer][ii,ni] += 2 * _learning_rate * delta_ni * m_layers_inputs[_curLayer][ii];
                }
            }
            BackPropagationRecursive(_learning_rate, _curLayer - 1, ref _correctedWeights, _layer_deltas);
        }
        else
        {
            double[] _layer_deltas = new double[_correctedWeights[_curLayer].length];
            for (int ni = 0; ni < _correctedWeights[_curLayer].length; ni++)
            {
                for (int ii = 0; ii < _correctedWeights[_curLayer][0].length; ii++)
                {
                    double delta_ni = 0.0;
                    double sum = 0.0;
                    for(int pr_l_n =0; pr_l_n < m_layers[_curLayer+1].Neuron_num; pr_l_n++) sum += _errorBuffer[pr_l_n]*m_layers[_curLayer+1].weights[ni, pr_l_n];
                    _layer_deltas[ni] = delta_ni = Helper.functions_deriviate_out[m_layers[_curLayer].Transfer_function](m_layers_outputs[_curLayer][ni]) * sum;
                    _correctedWeights[_curLayer][ii, ni] += 2 * _learning_rate * delta_ni * m_layers_inputs[_curLayer][ii];
                }
            }
            BackPropagationRecursive(_learning_rate, _curLayer - 1, ref _correctedWeights, _layer_deltas);
        }
	}
	/*
	private void BackPropagationRecursive(double _learning_rate, int _cur_layer, ref double[][,] _corrected_weights, double[] _data_buffer)
    {
        if (_cur_layer == 0) return;//input layer
        if (_cur_layer == this.m_layers.GetLength(0) - 1){//last layer
            double[] _layer_deltas = new double[m_layers[_cur_layer].Neuron_num];
            for (int ni = 0; ni < m_layers[_cur_layer].Neuron_num; ni++)
            {
                for (int ii = 0; ii < m_layers[_cur_layer].Inputs_num; ii++)
                {
                    double delta_ni = 0.0;
                    //double[] nets = Helper.MatrixMultiplication(m_layers_inputs[_cur_layer], m_layers[_cur_layer].weights);
                    _layer_deltas[ni] = delta_ni = _data_buffer[ni] * Helper.functions_deriviate_out[m_layers[_cur_layer].Transfer_function](m_layers_outputs[_cur_layer][ni]);
                    _corrected_weights[_cur_layer][ii,ni] += 2 * _learning_rate * delta_ni * m_layers_inputs[_cur_layer][ii];
                }
            }
            BackPropagationRecursive(_learning_rate, _cur_layer - 1, ref _corrected_weights, _layer_deltas);
        }
        else
        {
            double[] _layer_deltas = new double[m_layers[_cur_layer].Neuron_num];
            for (int ni = 0; ni < m_layers[_cur_layer].Neuron_num; ni++)
            {
                for (int ii = 0; ii < m_layers[_cur_layer].Inputs_num; ii++)
                {
                    double delta_ni = 0.0;
                    double sum = 0.0;
                    for(int pr_l_n =0; pr_l_n < m_layers[_cur_layer+1].Neuron_num; pr_l_n++) sum += _data_buffer[pr_l_n]*m_layers[_cur_layer+1].weights[ni, pr_l_n];
                    _layer_deltas[ni] = delta_ni = Helper.functions_deriviate_out[m_layers[_cur_layer].Transfer_function](m_layers_outputs[_cur_layer][ni]) * sum;
                    _corrected_weights[_cur_layer][ii, ni] += 2 * _learning_rate * delta_ni * m_layers_inputs[_cur_layer][ii];
                }
            }
            BackPropagationRecursive(_learning_rate, _cur_layer - 1, ref _corrected_weights, _layer_deltas);
        }
    }    */
	
}
