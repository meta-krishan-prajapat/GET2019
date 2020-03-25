package question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author krishan 
 * VCP class is the virtual command prompt class which is the main class
 *
 */
public class VCP {

	Folder currentFolder;// in which folder you are working currently
	List<String> folders = new ArrayList<String>();// for hierarchy of folder

	/**
	 * @return currentFolder, in which folder you are working currently
	 */
	public Folder getCurrentFolder() {
		return currentFolder;
	}

	/**
	 * @param currentFolder
	 */
	public void setCurrentFolder(Folder currentFolder) {
		this.currentFolder = currentFolder;
	}

	/**
	 * @return List folder
	 */
	public List<String> getFolders() {
		return folders;
	}

	/*
	 * Constructor
	 */
	public VCP() {
		currentFolder = new Folder("R");// root folder(Directory) created
	}

	/*
	 * Flow of Virtual command prompt will start from here
	 */
	public void runVcp() {
		try {
			String inputCommand;// input command for perform operation
			Scanner input = new Scanner(System.in);// input object for taking input

			// infinite loop ..will break when user will give "exit" command
			while (true) {

				printPath();// calling private method for printing current folder path on command prompt
				inputCommand = input.nextLine();// taking input from cmd for command

				String[] commands = inputCommand.split(" ");// Splitting command using spaces for separating command and
															// folder name

				// if command contain only single string then
				if (commands.length == 1) {

					switch (commands[0]) {

					case "bk":
						bk();
						break;

					case "ls":
						ls();
						break;

					case "tree":
						tree();
						break;
					case "exit":
						System.exit(0);
						break;

					default:
						System.out.println("Command Not found");
					}
				}

				else if (commands.length == 2) {

					switch (commands[0]) {

					case "mkdir":
						mkdir(commands[1]);
						break;

					case "cd":
						cd(commands[1]);
						break;

					case "find":
						find(commands[1]);
						break;

					default:
						System.out.println("Command Not found");
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param folderName is new folder name which is going to be create in this
	 *                   current folder
	 * 
	 */
	public void mkdir(String folderName) {
		try {
			if(folderName==null)
			{
				System.out.print("folder name can't be null");
			}
			else
			{
			// status of new folder creation in current folder with given name
			boolean status = this.getCurrentFolder().mkdir(folderName);

			// if folder is already exist with same name then new folder can't create with
			// given name
			if (status == false) {
				System.out.println("folder already exist with same name then new folder will not create");
			}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param folderName is sub folder name which is going to be current folder now
	 */
	public void cd(String folderName) {
		try {
			if(folderName==null)
			{
				System.out.print("folder name can't be null");
			}
			else
			{
			Folder subFolder = this.getCurrentFolder().cd(folderName);
			if (subFolder != null) {
				this.setCurrentFolder(subFolder);
				this.folders.add(subFolder.getFolderName());
			} else {
				System.out.println("folder doesn't exist with this name");
			}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param folderName is for finding folder recursively in current folder in it's
	 *                   sub folder as well
	 */
	public void find(String folderName) {
		try {
			if(folderName==null)
			{
				System.out.print("folder name can't be null");
			}
			else
			{
			Folder foundFolder = this.getCurrentFolder().find(folderName);
			if (foundFolder != null) {
				String path = getPathOfFolder(foundFolder);
				System.out.println(path);
			} else {
				System.out.println("Not Found");
			}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param foundFolder is for finding path of given folder
	 * @param path        is the path of foundFolder in string form
	 */
	private String getPathOfFolder(Folder foundFolder) {
		String path = null;
		try {

			// setting currentFolder to foundFoder as from there only you will reach to it's
			// parent
			Folder currentFolder = foundFolder;

			// making a stack for maintaining the hierarchy
			Stack<String> folders = new Stack<String>();

			// path as string
			path = new String(" ");

			// moving from current folder to towards it's parent and recursively doing this
			// until reach null because null is parent of root
			// and continuously pushing current folder in stack
			while (currentFolder != null) {
				folders.push(currentFolder.getFolderName());
				currentFolder = currentFolder.getRootFolder();
			}

			// popping folders'name one by one as it will start from root because at last
			// root was pushed
			// we will pop until stack get empty
			while (!folders.empty()) {
				path = path + "/" + folders.pop();// adding folder in path
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// returning whole path of folder
		return path;
	}

	/**
	 * moving form current directory to it's parent directory
	 */
	public void bk() {
		try {

			if (this.getCurrentFolder().getRootFolder() != null) {
				// setting or moving from current folder to it's parent folder
				this.setCurrentFolder(this.getCurrentFolder().getRootFolder());

				// removing last folder name from list
				this.folders.remove(this.folders.size() - 1);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * will print all the subFolder in this folder
	 */
	public void ls() {
		try {
			List<Folder> subFolders = this.getCurrentFolder().ls();

			for (Folder subFolder : subFolders) {
				System.out.println(subFolder.getDateAndTime() + "  " + subFolder.getFolderName());
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception
	 * print the tree
	 */
	public void tree() throws Exception {
		printTree(this.getCurrentFolder(), 0);

	}

	/**
	 * method to display the tree of the given directory
	 * 
	 * @param currentDirectory
	 * @param nesting          is the level of the subfolder
	 */
	int x = 1;

	private void printTree(Folder currentDirectory, int nesting) {
		try {
			if(currentDirectory==null)
			{
				System.out.print("directory can't be null");
			}
			else
			{
			for (Folder subDirectory : currentDirectory.getSubFolders()) {
				for (int i = 0; i < nesting; i++)
					System.out.print("|    ");
				if (subDirectory.getSubFolders().size() != 0) {
					System.out.println("|___" + subDirectory.getFolderName());

					printTree(subDirectory, nesting + 1);
				} else
					System.out.println("|___" + subDirectory.getFolderName());

			}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Will print the whole path of current working directory
	 */
	private void printPath() {
		try {
			System.out.print("R:");
			for (String folderName : this.getFolders()) {
				System.out.print("\\" + folderName);
			}

			System.out.print(">");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// main method
	public static void main(String[] args) {
		VCP command = new VCP();
		command.runVcp();
	}

}
