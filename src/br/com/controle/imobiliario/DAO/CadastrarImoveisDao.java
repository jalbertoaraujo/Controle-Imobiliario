package br.com.controle.imobiliario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.controle.imobiliario.model.ConnectionFactory;
import br.com.controle.imobiliario.view.novoUsuario;
import br.com.controle.imobiliario.view.principal;

public class CadastrarImoveisDao {

	private Connection connection;

	public CadastrarImoveisDao() {

		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrarImoveis(principal princi) {

		String sql = "INSERT INTO imoveis (usuario, empreendimento, descricao, endereco, valor, tipo, sequencial, caracteristica, area, registro, cartorio, estado, cidade, codimovel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, principal.tfusuarioprincipal.getText());
			ps.setString(2, principal.tfempreendimentoprincipal.getText());
			ps.setString(3, principal.tfdescricaoprincipal.getText());
			ps.setString(4, principal.tfendereçoprincipal.getText());
			ps.setDouble(5, Double.parseDouble(principal.tfvalorprincipal.getText()));
			ps.setString(6, principal.cbtipoprincipal.getSelectedItem().toString());
			ps.setString(7, principal.tfsequencialprincipal.getText());
			ps.setString(8, principal.tfcarecteristicaprincipal.getText());
			ps.setString(9, principal.tfareaprincipal.getText());
			ps.setString(10, principal.tfregistroprincipal.getText());
			ps.setString(11, principal.tfcartorioprincipal.getText());
			ps.setString(12, principal.cbestadoprincipal.getSelectedItem().toString());
			ps.setString(13, principal.tfcidadeprincipal.getText());
			ps.setString(14, principal.tfcodigoimovel.getText());
			ps.execute();
			ps.close();
			JOptionPane.showMessageDialog(null, "NOVO IMÓVEL CADASTRADO COM SUCESSO");
			principal.tfempreendimentoprincipal.setText("");
			principal.tfdescricaoprincipal.setText("");
			principal.tfvalorprincipal.setText("");
			principal.tfendereçoprincipal.setText("");
			principal.tfsequencialprincipal.setText("");
			principal.tfcarecteristicaprincipal.setText("");
			principal.tfareaprincipal.setText("");
			principal.tfregistroprincipal.setText("");
			principal.tfcartorioprincipal.setText("");
			principal.tfcidadeprincipal.setText("");
			principal.tfcodigoimovel.setText("");
			principal.cbestadoprincipal.setSelectedIndex(0);
			principal.cbtipoprincipal.setSelectedIndex(0);
			principal.tfempreendimentoprincipal.setEditable(false);
			principal.tfdescricaoprincipal.setEditable(false);
			principal.tfcarecteristicaprincipal.setEditable(false);
			principal.tfareaprincipal.setEditable(false);
			principal.tfsequencialprincipal.setEditable(false);
			principal.tfvalorprincipal.setEditable(false);
			principal.tfendereçoprincipal.setEditable(false);
			principal.tfcidadeprincipal.setEditable(false);
			principal.tfregistroprincipal.setEditable(false);
			principal.tfcartorioprincipal.setEditable(false);
			//principal.tfdescricaoprincipal.requestFocus();
		} catch (SQLException erro) {
			throw new RuntimeException(erro);
		}
	}
}
