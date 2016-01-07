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
	private JLabel descriptionLabel;
	private int goblinNumberPanel;
	public boolean isAttacking;
	
	
	
	public RPGPanel(RPGAppController baseController)
	{
		Monster [] tempGoblins = baseController.getFirstGoblin().getGoblins();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		attackButton = new JButton("ATTACK");
		health = new JLabel("20/20");
		mobStats = new JCheckBox("monster's stats");
		nameLabel = new JLabel(tempGoblins[goblinNumberPanel].getName());
		descriptionLabel = new JLabel(tempGoblins[goblinNumberPanel].getDescription());
		goblinNumberPanel = 1;
		isAttacking = false;
		
		
		
		
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
		this.add(descriptionLabel);
		nameLabel.setVisible(false);
		descriptionLabel.setVisible(false);
	
		
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
					descriptionLabel.setVisible(true);
					nameLabel.setText(tempGoblins[goblinNumberPanel].getName());
					descriptionLabel.setText(tempGoblins[goblinNumberPanel].getDescription());
				}
				else
				{
					nameLabel.setVisible(false);
					descriptionLabel.setVisible(false);
				}
			}
		});
		
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				isAttacking = true;
				baseController.getPlayerHealthCurrent();
				health.setText(baseController.getPlayerHealthCurrent() + "/" + baseController.getPlayerHealthMax());
			}
		});
	}
}

