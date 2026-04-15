# 🎬 PopFlicks – Movie Discovery Android App

PopFlicks is an Android application built using the **TMDB (The Movie Database) API**.  
It allows users to browse popular movies, search for movies, view detailed information, and manage a persistent watchlist.

---

## 📱 Features

### 🏠 Home Screen
- Displays a paginated list of popular movies
- Each movie item includes:
    - Poster image
    - Title
    - Release year
    - Rating
- Supports infinite scrolling (pagination)

---

### 🔍 Search Screen
- Search movies by name using TMDB API
- Debounced search implementation (prevents API call on every keystroke)
- Paginated search results
- Handles empty state when no results are found

⚠️ Note: Search functionality and pagination improvements are still in progress and will be completed with more time.

---

### 🎬 Movie Detail Screen
- Displays full movie details:
    - Poster
    - Title
    - Overview
    - Rating
    - Runtime
    - Genres
- Cast list with actor name and profile image
- Horizontally scrollable similar movies section
- Add / Remove movie from Watchlist

---

### 🔖 Watchlist Screen
- Shows saved movies
- Data persists across app restarts using local storage
- Users can remove movies from watchlist

---

## 🔑 TMDB API Setup

### Step 1: Create API Key
- Sign up at https://www.themoviedb.org/
- Go to **Settings → API**
- Generate a free API key (no billing required)

---

### Step 2: Base URL