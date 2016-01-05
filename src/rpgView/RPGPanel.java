package rpgView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import rpgModel.Monster;
import rpgController.RPGAppController;

public class RPGPanel extends JPanel
{

	private SpringLayout baseLayout;
	private RPGAppController baseController;
	private JButton attackButton;
	private JLabel health;
	private JButton mobStats;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private int startClick;
	private int maxClicks;
	
	public RPGPanel(RPGAppController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		attackButton = new JButton("ATTACK");
		health = new JLabel("20/20");
		mobStats = new JButton("monster's stats");
		nameLabel = new JLabel("the name");
		descriptionLabel = new JLabel("description");
		maxClicks = baseController.getFirstGoblin().getGoblins().length;
		startClick = 0;
		
		
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
			public void actionPerformed(ActionEvent click)
			{
				Monster [] tempGoblins = baseController.getFirstGoblin().getGoblins();
				if(startClick < maxClicks)
				{
					nameLabel.setText(tempGoblins[startClick].getName());
					descriptionLabel.setText(tempGoblins[startClick].getDescription());
					nameLabel.setVisible(true);
					descriptionLabel.setVisible(true);
					startClick++;
				}
				else
				{
					startClick = 0;
					nameLabel.setText("");
					descriptionLabel.setText("");
				}
			}
		});
	}
}

