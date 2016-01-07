package rpgView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import rpgModel.Monster;
import rpgModel.Goblin;
import rpgController.RPGAppController;
import rpgModel.Attacking;

public class RPGPanel extends JPanel
{

	private SpringLayout baseLayout;
	private RPGAppController baseController;
	private JButton attackButton;
	private JLabel health;
	private JCheckBox mobStats;
	private JLabel nameLabel;
	private JLabel healthMob;
	private JLabel descriptionLabel;
	private int goblinNumberPanel;
	
	
	
	
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
		baseLayout.putConstraint(SpringLayout.NORTH, health, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, health, 0, SpringLayout.WEST, attackButton);
		baseLayout.putConstraint(SpringLayout.NORTH, healthMob, 6, SpringLayout.SOUTH, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.WEST, healthMob, 0, SpringLayout.WEST, nameLabel);
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
				
				baseController.getPlayerHealthCurrent();
				health.setText("Health: " + baseController.getPlayerHealthCurrent() + "/" + baseController.getPlayerHealthMax());
			}
		});
	}
}

