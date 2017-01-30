package bulkImport;

import java.util.logging.Logger;


public class bulkImport {
	private final static Logger log = Logger.getLogger(bulkImport.class.getName());
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	public static void main(String args[])
	{
		try {
			String bulkImportCommand = "  -user tsuper -password tsuper  -move -ignore ";
			if(args.length != 6)
			{
				log.info("Please provide the BulkImportCommandLocation,sourcedirectorylocation,mode,folderid,templateid,count");
				System.exit(0);
			}
			else
			{
				if(!bulkImport.isBlank(args[0]))
				{
					bulkImportCommand=args[0]+bulkImportCommand;
				}

				if(!bulkImport.isBlank(args[1]))
				{
					bulkImportCommand=bulkImportCommand+" -dir "+ args[1];
				}

				if(!bulkImport.isBlank(args[2]))
				{
					bulkImportCommand=bulkImportCommand+" -mode "+ args[2];
				}

				if(!bulkImport.isBlank(args[3]))
				{
					bulkImportCommand=bulkImportCommand+" -folder "+ args[3];
				}

				if(!bulkImport.isBlank(args[4]))
				{
					bulkImportCommand=bulkImportCommand+" -profile "+ args[4];
				}
				if(!bulkImport.isBlank(args[4]))
				{
					bulkImportCommand=bulkImportCommand+" -count "+ args[5];
				}

				//Run batch file using java
				
				log.info("bulkImportCommand"+bulkImportCommand);
				Process p = Runtime.getRuntime().exec(bulkImportCommand);
			}
		} catch (Exception e) {
			log.info("An exception occured"+e.getMessage());
		}
	}
}
