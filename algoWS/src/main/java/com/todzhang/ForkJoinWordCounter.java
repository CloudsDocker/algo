import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ForkJoinWordCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			final ForkJoinPool pool=new ForkJoinPool();
			Folder folder;
//			folder = Folder.fromDirectory(new File("C:\\Users\\43888859\\workspace\\algo\\src\\me\\todzhang\\"));
			File file=new File("/Users/todzhang/dev/git/algo/algoWS/src/main/java/com/todzhang/");
			String path=file.getCanonicalPath();
			folder = Folder.fromDirectory(file);

			String searchWord="ForkJoinPool";
			System.out.println(pool.invoke(new FolderSearchTask(folder, searchWord)));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	static class Document{
		private final List<String> lines;

		public Document(List<String> lines) {
			super();
			this.lines = lines;
		}
		
		List<String> getLines(){
			return lines;
		}
		
		static Document fromFile(File file) throws IOException{
			List<String> lines=new LinkedList<String>();
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=reader.readLine();
			while(line!=null){
				lines.add(line);
				line=reader.readLine();
			}				
			reader.close();
			return new Document(lines);
		}
	}
	
	static class Folder{
		private final List<Folder> subFolders;
		private final List<Document> documents;
		public Folder(List<Folder> subFolders, List<Document> documents) {
			super();
			this.subFolders = subFolders;
			this.documents = documents;
		}
		public List<Folder> getSubFolders() {
			return subFolders;
		}
		public List<Document> getDocuments() {
			return documents;
		}
		
		static Folder fromDirectory(File dir) throws IOException{
			List<Document> documents=new LinkedList<Document>();
			List<Folder> subFolders=new LinkedList<Folder>();
			for (File entry : dir.listFiles()) {
				if(entry.isDirectory()){
					subFolders.add(Folder.fromDirectory(entry));
				}
				else{
					documents.add(Document.fromFile(entry));
				}
			}		
			
			return new Folder(subFolders,documents);
		}
		
	}
	
	static String[] wordsIn(String line){
		return line.trim().split("(\\s|\\p{Punct})+");
	}
	
	static Long occurrencesCount(Document document, String searchWord){
		long count=0;
		for (String line : document.getLines()) {
			for (String word : wordsIn(line)) {
				if(searchWord.equals(word)){
					count++;
				}
					
			}
		}
		return count;
	}
	
	static class DocumentSearchTask extends RecursiveTask<Long>{
		private final Document document;
		private final String searchWord;
		public DocumentSearchTask(Document document, String searchWord) {
			super();
			this.document = document;
			this.searchWord = searchWord;
		}
		@Override
		protected Long compute() {
			// TODO Auto-generated method stub
			return occurrencesCount(document, searchWord);
		}
	}
	
	static class FolderSearchTask extends RecursiveTask<Long>{
		private final Folder folder;
		private final String searchWord;
		public FolderSearchTask(Folder folder, String searchWord) {
			super();
			this.folder = folder;
			this.searchWord = searchWord;
		}
		
		@Override
		protected Long compute(){
			long count=0L;
			List<RecursiveTask<Long>> forks=new LinkedList<>();
			for (Folder subFolder : folder.getSubFolders()) {
				FolderSearchTask task=new FolderSearchTask(subFolder, searchWord);
				forks.add(task);
				task.fork();
			}
			
			for (Document document : folder.getDocuments()) {
				DocumentSearchTask task=new DocumentSearchTask(document, searchWord);
				forks.add(task);
				task.fork();				
			}
			
			for (RecursiveTask<Long> recursiveTask : forks) {
				count=count+recursiveTask.join();
			}
			
			return count;
		}
	}
}
