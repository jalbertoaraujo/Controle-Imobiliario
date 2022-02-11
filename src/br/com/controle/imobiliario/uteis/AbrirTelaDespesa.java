package br.com.controle.imobiliario.uteis;

import br.com.controle.imobiliario.view.AlterarNovaDespesa;
import br.com.controle.imobiliario.view.IncluirNovaDespesa;

public class AbrirTelaDespesa {

	public void abretela() {

		AlterarNovaDespesa and = new AlterarNovaDespesa();
		and.setVisible(true);
		
		int ind = IncluirNovaDespesa.table.getSelectedRow();
		
		and.tfidalterartipodespesa.setText(IncluirNovaDespesa.table.getValueAt(ind, 0).toString());
		and.tfalterartipodespesa.setText(IncluirNovaDespesa.table.getValueAt(ind, 1).toString());
	}
}
