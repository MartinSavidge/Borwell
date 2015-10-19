package RoomChallenge;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Room Calculation GUI class
 *
 * @author Martin Savidge
 *
 *         A GUI based solution for THe Borwell RoomChallenge program.
 *
 *         Generated using WindowBuilder under Eclipse.
 *
 *         Provides the user interface to enter the dimensions and display the
 *         calculated output.
 */
public class RoomCalc {

	protected Shell shlBorwerllRoomCalculator; // The GUI window

	// User input dimensions
	private Text inputLength;
	private Text inputWidth;
	private Text inputHeight;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            - not used
	 */
	public static void main(String[] args) {
		try {
			RoomCalc window = new RoomCalc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlBorwerllRoomCalculator.open();
		shlBorwerllRoomCalculator.layout();
		while (!shlBorwerllRoomCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		// An SWT shell window
		shlBorwerllRoomCalculator = new Shell();
		shlBorwerllRoomCalculator.setSize(458, 301);
		shlBorwerllRoomCalculator.setText("Borwerll Room Calculator");
		shlBorwerllRoomCalculator.setToolTipText("Room data calculator - Enter room dimensions in metres...");

		// The dimensions input fields
		Group groupDimensions = new Group(shlBorwerllRoomCalculator, SWT.NONE);
		groupDimensions.setBounds(5, -5, 156, 204);

		Composite composite = new Composite(groupDimensions, SWT.NONE);
		composite.setBounds(3, 15, 150, 186);

		Label labelDimensions = new Label(composite, SWT.NONE);
		labelDimensions.setBounds(0, 0, 142, 15);
		labelDimensions.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelDimensions.setText("Room dimensions (m)");

		// Length
		Label labelLength = new Label(composite, SWT.NONE);
		labelLength.setBounds(4, 34, 37, 15);
		labelLength.setText("Length");

		inputLength = new Text(composite, SWT.BORDER);
		inputLength.setBounds(4, 56, 76, 21);
		inputLength.setToolTipText("Length of room (from back wall to front) in metres");

		// Width
		Label labelWidth = new Label(composite, SWT.NONE);
		labelWidth.setBounds(4, 86, 32, 15);
		labelWidth.setText("Width");

		inputWidth = new Text(composite, SWT.BORDER);
		inputWidth.setBounds(4, 108, 76, 21);
		inputWidth.setToolTipText("Width of room (side to side) in metres");

		// Height
		Label labelHeight = new Label(composite, SWT.NONE);
		labelHeight.setBounds(4, 138, 36, 15);
		labelHeight.setText("Height");

		inputHeight = new Text(composite, SWT.BORDER);
		inputHeight.setBounds(4, 160, 76, 21);
		inputHeight.setToolTipText("Height of room (floor to ceiling) in metres");

		// Outputs

		// Area - a bounded group
		Group groupArea = new Group(shlBorwerllRoomCalculator, SWT.NONE);
		groupArea.setBounds(189, 19, 247, 44);

		Composite compositeArea = new Composite(groupArea, SWT.NONE);
		compositeArea.setBounds(3, 15, 241, 26);

		// Label - text
		Label labelArea = new Label(compositeArea, SWT.NONE);
		labelArea.setBounds(4, 5, 110, 15);
		labelArea.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelArea.setText("Area of room:");
		labelArea.setToolTipText("The calculated floor area in m\u00B2");

		// Value - leave blank until calculation is performed
		Label outputArea = new Label(compositeArea, SWT.NONE);
		outputArea.setBounds(118, 5, 64, 15);
		outputArea.setAlignment(SWT.RIGHT);
		outputArea.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		outputArea.setText(" ");
		outputArea.setToolTipText("The calculated floor area in m\u00B2");

		// Units - m²
		Label labelM2 = new Label(compositeArea, SWT.NONE);
		labelM2.setBounds(188, 5, 42, 15);
		labelM2.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelM2.setText("m\u00B2");

		// Paint requirements - a bounded group
		Group groupPaint = new Group(shlBorwerllRoomCalculator, SWT.NONE);
		groupPaint.setBounds(189, 65, 247, 48);

		Composite compositePaint = new Composite(groupPaint, SWT.NONE);
		compositePaint.setBounds(3, 15, 241, 30);

		Label labelPaintRequired = new Label(compositePaint, SWT.NONE);
		labelPaintRequired.setBounds(4, 5, 110, 15);
		labelPaintRequired.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelPaintRequired.setText("Paint Required:");
		labelPaintRequired.setToolTipText("The approximate amount of paint needed for one coat of the walls");

		Label outputPaint = new Label(compositePaint, SWT.NONE);
		outputPaint.setBounds(118, 5, 64, 15);
		outputPaint.setAlignment(SWT.RIGHT);
		outputPaint.setText(" ");
		outputPaint.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		outputPaint.setToolTipText("The approximate amount of paint needed for one coat of the walls");

		Label labelLitres = new Label(compositePaint, SWT.NONE);
		labelLitres.setBounds(188, 5, 43, 15);
		labelLitres.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelLitres.setText("litres");

		// Volume - a bounded group
		Group groupVolume = new Group(shlBorwerllRoomCalculator, SWT.NONE);
		groupVolume.setBounds(189, 111, 247, 48);

		Composite compositeVolume = new Composite(groupVolume, SWT.NONE);
		compositeVolume.setBounds(3, 15, 241, 30);

		Label labelVolume = new Label(compositeVolume, SWT.NONE);
		labelVolume.setBounds(4, 5, 109, 15);
		labelVolume.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelVolume.setText("Volume of room:");
		labelVolume.setToolTipText("The volume of the room in m\u00B3");

		Label outputVolume = new Label(compositeVolume, SWT.NONE);
		outputVolume.setBounds(118, 5, 64, 15);
		outputVolume.setAlignment(SWT.RIGHT);
		outputVolume.setText(" ");
		outputVolume.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		outputVolume.setToolTipText("The volume of the room in m\u00B3");

		Label labelM3 = new Label(compositeVolume, SWT.NONE);
		labelM3.setBounds(188, 5, 39, 15);
		labelM3.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		labelM3.setText("m\u00B3");

		// A button to request calculation
		Button buttonCalculate = new Button(shlBorwerllRoomCalculator, SWT.NONE);
		buttonCalculate.setBounds(189, 187, 113, 48);
		buttonCalculate.setImage(SWTResourceManager.getImage(RoomCalc.class, "/RoomChallenge/check-icon.png"));
		buttonCalculate.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		buttonCalculate.setText("Calculate");
		buttonCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					// Read all the input dimensions
					double length = Double.parseDouble(inputLength.getText());
					double width = Double.parseDouble(inputWidth.getText());
					double height = Double.parseDouble(inputHeight.getText());

					// Instantiate the room under calculation
					Room theRoom = new Room(length, width, height);

					// Generate the output
					outputArea.setText(theRoom.getFormattedAreaOfFloor());
					outputPaint.setText(theRoom.getFormattedAmountOfPaint());
					outputVolume.setText(theRoom.getFormattedVolumeOfRoom());
				} catch (Exception except) {
					// Presumably one/more of the three dimensions has not been
					// entered correctly
					MessageDialog.openError(shlBorwerllRoomCalculator, "Error",
							"Invalid dimensions - Please enter in metres");
					return;
				}
			}
		});
		buttonCalculate.setToolTipText("Click to recalculate (all dimensions must have be input)...");

		// Attempt to automatically do calculation once the height has been
		// input (assuming most users will input length, width then height)
		inputHeight.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				try {
					// Attempt to get input dimensions
					double length = Double.parseDouble(inputLength.getText());
					double width = Double.parseDouble(inputWidth.getText());
					double height = Double.parseDouble(inputHeight.getText());

					// Instantiate the room under calculation
					Room theRoom = new Room(length, width, height);

					// Generate the output
					outputArea.setText(theRoom.getFormattedAreaOfFloor());
					outputPaint.setText(theRoom.getFormattedAmountOfPaint());
					outputVolume.setText(theRoom.getFormattedVolumeOfRoom());
				} catch (Exception except) {
					// Ignore - presumably other dimensions are not yet
					// available
				}
			}
		});

		// An OK button to dismiss the window
		Button buttonDone = new Button(shlBorwerllRoomCalculator, SWT.NONE);
		buttonDone.setBounds(345, 187, 88, 48);
		buttonDone.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		buttonDone.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlBorwerllRoomCalculator.close();
			}
		});
		buttonDone.setText("OK");
		buttonDone.setToolTipText("Close window");

		// Menus - just the basics
		Menu menu = new Menu(shlBorwerllRoomCalculator, SWT.BAR);
		menu.addMenuListener(new MenuAdapter() {
			@Override
			public void menuShown(MenuEvent e) {
			}
		});
		shlBorwerllRoomCalculator.setMenuBar(menu);

		// Menu File->Exit
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");

		Menu menuFile = new Menu(mntmFile);
		mntmFile.setMenu(menuFile);

		MenuItem mntmExit = new MenuItem(menuFile, SWT.NONE);
		mntmExit.setText("Exit");
		// On click - just exit the program
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlBorwerllRoomCalculator.close();
			}
		});

		// Menu Help->About
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");

		Menu menuHelp = new Menu(mntmHelp);
		mntmHelp.setMenu(menuHelp);

		MenuItem mntmAbout = new MenuItem(menuHelp, SWT.NONE);
		mntmAbout.setText("About");
		// On click - just an about message in a dialog
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(shlBorwerllRoomCalculator, "Info",
						"Program to calculate:\n"
								+ " - the floor area,\n"
								+ " - the approximate paint requirments for a single coat of the walls,\n"
								+ " - and the volume\n"
								+ "    for a room of the given input dimensions.\n"
								+ "Developed for The Borwell Software Challenge - Martin Savidge - Oct 2015");
			}
		});
	}
}
