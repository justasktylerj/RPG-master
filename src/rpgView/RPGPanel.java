package rpgView;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import rpgModel.Monster;
import rpgModel.Goblin;
import rpgController.RPGAppController;



public class RPGPanel extends JPanel
{

	private SpringLayout baseLayout;
	private RPGAppController baseController;
	private RPGAppController attackController;
	private JButton attackButton;
	private JLabel health;
	private JCheckBox mobStats;
	private JLabel nameLabel;
	private JLabel healthMob;
	private JLabel descriptionLabel;
	private int goblinNumberPanel;
	private JLabel narration1;
	private JLabel narration2;
	private JLabel narration3;
	
	public RPGPanel(RPGAppController baseController)
	{
		Monster [] tempGoblins = baseController.getFirstGoblin().getGoblins();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		attackButton = new JButton("ATTACK");
		health = new JLabel("Health: 20/20");
		mobStats = new JCheckBox("monster's stats");
		nameLabel = new JLabel(tempGoblins[goblinNumberPanel].getName());
		descriptionLabel = new JLabel(tempGoblins[goblinNumberPanel].getDescription());
		healthMob = new JLabel("" + tempGoblins[goblinNumberPanel].getMobHealthCurrent());
		goblinNumberPanel = 1;
		narration1 = new JLabel("empty 1");
		narration2 = new JLabel("empty 2");
		narration3 = new JLabel("empty 3");
		
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
     
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(attackButton);
		this.add(health);
		this.add(mobStats);
		this.add(nameLabel);
		this.add(healthMob);
		this.add(narration1);
		this.add(narration2);
		this.add(narration3);
		this.add(descriptionLabel);
		nameLabel.setVisible(false);
		descriptionLabel.setVisible(false);
		healthMob.setVisible(false);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, attackButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, attackButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, mobStats, 0, SpringLayout.NORTH, attackButton);
		baseLayout.putConstraint(SpringLayout.WEST, mobStats, 2, SpringLayout.EAST, attackButton);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -6, SpringLayout.NORTH, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, descriptionLabel, -58, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, descriptionLabel, -65, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, healthMob, 6, SpringLayout.SOUTH, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.WEST, healthMob, 0, SpringLayout.WEST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, health, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, health, 0, SpringLayout.WEST, attackButton);
		baseLayout.putConstraint(SpringLayout.WEST, narration1, 0, SpringLayout.WEST, attackButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, narration1, -6, SpringLayout.NORTH, attackButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, narration2, -6, SpringLayout.NORTH, narration1);
		baseLayout.putConstraint(SpringLayout.EAST, narration2, 0, SpringLayout.EAST, narration1);
		baseLayout.putConstraint(SpringLayout.SOUTH, narration3, -6, SpringLayout.NORTH, narration2);
		baseLayout.putConstraint(SpringLayout.EAST, narration3, 0, SpringLayout.EAST, narration1);
	}
	
	private void setupListeners()
	{
		mobStats.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Monster [] tempGoblins = baseController.getFirstGoblin().getGoblins();
				goblinNumberPanel = baseController.getGoblinNumber();
				if(mobStats.isSelected())
				{
					nameLabel.setVisible(true);
					healthMob.setVisible(true);
					descriptionLabel.setVisible(true);
					nameLabel.setText(tempGoblins[goblinNumberPanel].getName());
					descriptionLabel.setText(tempGoblins[goblinNumberPanel].getDescription());
					healthMob.setText("Health:" + tempGoblins[goblinNumberPanel].getMobHealthCurrent());
				}
				else
				{
					nameLabel.setVisible(false);
					descriptionLabel.setVisible(false);
					healthMob.setVisible(false);
				}
			}
		});
		
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.attackMonster();
				boolean IsPlayersTurn = false;
				baseController.getPlayerHealthCurrent();
				health.setText("Health: " + baseController.getPlayerHealthCurrent() + "/" + baseController.getPlayerHealthMax());
			}

			
		});
	}
}

