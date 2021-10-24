package instagram.project.response;

public class PostInstagramResponse {
		private int id;
		private int idUser;
		private String codeCaption;
		private String caption;
		private String username;
		public PostInstagramResponse(int id, int idUser, String codeCaption, String caption, String username) {
			this.id = id;
			this.idUser = idUser;
			this.codeCaption = codeCaption;
			this.caption = caption;
			this.username = username;
		}
		public PostInstagramResponse() {
		}
		@Override
		public String toString() {
			return "PostInstagramResponse [id=" + id + ", idUser=" + idUser + ", codeCaption=" + codeCaption
					+ ", caption=" + caption + ", username=" + username + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getIdUser() {
			return idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		public String getCodeCaption() {
			return codeCaption;
		}
		public void setCodeCaption(String codeCaption) {
			this.codeCaption = codeCaption;
		}
		public String getCaption() {
			return caption;
		}
		public void setCaption(String caption) {
			this.caption = caption;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		
		
}
