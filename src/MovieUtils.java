public class MovieUtils {
	// Return the movie with the given id if found, null otherwise.
	public static Movie findMovieById(List<Movie> movies, int id) {
		if (movies.empty() == true)
			return null;
		movies.findFirst();
		while (movies.last() == false) {
			if (movies.retrieve().id == id)
				return movies.retrieve();
			movies.findNext();
		}
		if (movies.retrieve().id == id)
			return movies.retrieve();

		return null;
	}

	// Return the list of movies having a given title. If none is found, empty list
	// is returned.
	public static List<Movie> findMovieByTitle(List<Movie> movies, String title) {
		List<Movie> tmp = new LinkedList<Movie>();
		if (movies.empty() == true || title == null)
			return tmp;
		movies.findFirst();
		while (movies.last() == false) {
			if (movies.retrieve().title != null)
				if (movies.retrieve().title.equals(title))
					tmp.insert(movies.retrieve());
			movies.findNext();
		}
		if (movies.retrieve().title != null)
			if (movies.retrieve().title.equals(title))
				tmp.insert(movies.retrieve());

		return tmp;
	}

	// Return the list of movies of a given genre. If none is found, empty list is
	// returned.
	public static List<Movie> findMoviesByGenre(List<Movie> movies, String genre) {
		// List<String> y= movies.retrieve().genres;

		List<Movie> tmp = new LinkedList<Movie>();
		if (movies.empty() == true || genre == null)
			return tmp;

		StringEqualCond s = new StringEqualCond(genre);
		movies.findFirst();
		while (movies.last() == false) {
			if (movies.retrieve().genres != null)
				if (!movies.retrieve().genres.empty())
					if (movies.retrieve().genres.findFirstEle(s)) {
						tmp.insert(movies.retrieve());
					}
			movies.findNext();
		}
		if (movies.retrieve().genres != null)
			if (!movies.retrieve().genres.empty())
				if (movies.retrieve().genres.findFirstEle(s))
					tmp.insert(movies.retrieve());
		// use find first element
		return tmp;
	}
	// sarch

	// Return the list of movies of given genres (a movie must have all genres to be
	// in the list). If none is found, empty list is returned. Assume genres is not
	// empty.
	public static List<Movie> findMoviesByGenres(List<Movie> movies, List<String> genres) {

		List<Movie> tmp = new LinkedList<Movie>();
		if (movies.empty() == true || genres.empty() == true)
			return tmp;
		int i = 1;
		genres.findFirst();
		while (genres.last() == false) {
			i++;
			genres.findNext();
		}

		int j = 0;

		movies.findFirst();
		while (movies.last() == false) {
			genres.findFirst();
			j = 0;
			while (genres.last() == false) {
				if (movies.retrieve().genres != null)
					if (!movies.retrieve().genres.empty())
						if (genres.retrieve() != null)
							if (movies.retrieve().genres.findFirstEle(new StringEqualCond(genres.retrieve()))) {
								j++;
								if (j == i)
									tmp.insert(movies.retrieve());
							}
				genres.findNext();
			}
			if (movies.retrieve().genres != null)
				if (!movies.retrieve().genres.empty())
					if (genres.retrieve() != null)
						if (movies.retrieve().genres.findFirstEle(new StringEqualCond(genres.retrieve()))) {
							j++;
							if (j == i)
								tmp.insert(movies.retrieve());
						}
			movies.findNext();
		}
		genres.findFirst();
		j = 0;
		while (genres.last() == false) {
			if (movies.retrieve().genres != null)
				if (!movies.retrieve().genres.empty())
					if (genres.retrieve() != null)
						if (movies.retrieve().genres.findFirstEle(new StringEqualCond(genres.retrieve()))) {
							j++;
							if (j == i)
								tmp.insert(movies.retrieve());
						}
			genres.findNext();
		}
		if (movies.retrieve().genres != null)
			if (!movies.retrieve().genres.empty())
				if (genres.retrieve() != null)
					if (movies.retrieve().genres.findFirstEle(new StringEqualCond(genres.retrieve()))) {
						j++;
						if (j == i)
							tmp.insert(movies.retrieve());
					}

		return tmp;

	}

}
