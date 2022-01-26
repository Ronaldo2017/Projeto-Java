package com.br.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {

	// painel de componentes
	private JPanel jPanel = new JPanel(new GridBagLayout());

	private JLabel descricaoHora = new JLabel("Time thread 1");
	private JTextField tempo = new JTextField();
	private JLabel descricaoHora2 = new JLabel("Time thread 2");
	private JTextField tempo2 = new JTextField();

	private JButton jButtonStart = new JButton("Start");
	private JButton jButtonStop = new JButton("Stop");

	private Runnable thread = new Runnable() {

		public void run() {
			while (true) {
				tempo.
				setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	};
	
	
	private Runnable thread2 = new Runnable() {

		public void run() {
			while (true) {
				tempo2.
				setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	};
	
	private Thread thread1Time;
	private Thread thread2Time;

	// EXECUTA O QUE TIVER DENTRO NO MOMENTO DA EXECUÇÃO
	public TelaTimeThread() {
		// configurações iniciais da tela
		setTitle("Tela de time com Thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);

		// controlador de posicionamento na tela
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		// linha
		gridBagConstraints.gridx = 0;
		// coluna
		gridBagConstraints.gridy = 0;
		// largura dos componentes
		gridBagConstraints.gridwidth = 2;
		// posicionamento
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);

		tempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		tempo.setEditable(false);// desabilita o campo
		jPanel.add(tempo, gridBagConstraints);

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);

		tempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		tempo2.setEditable(false);// desabilita o campo
		jPanel.add(tempo2, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		jButtonStart.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(jButtonStart, gridBagConstraints);

		jButtonStop.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jButtonStop, gridBagConstraints);

		// clique do botao
		jButtonStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				thread1Time = new Thread(thread);
				thread1Time.start();
				
				thread2Time = new Thread(thread2);
				thread2Time.start();
				
				jButtonStart.setEnabled(false);
				jButtonStop.setEnabled(true);
			}
		});

		jButtonStop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				thread1Time.stop();
				thread2Time.stop();
				
				jButtonStart.setEnabled(true);
				jButtonStop.setEnabled(false);
			}
		});
		
		jButtonStop.setEnabled(false);

		add(jPanel, BorderLayout.WEST);

		// sempre o último a ser executado
		// tela fica visivel ao usuario
		setVisible(true);
	}

}
