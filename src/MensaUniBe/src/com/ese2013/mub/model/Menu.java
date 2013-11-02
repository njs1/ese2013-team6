package com.ese2013.mub.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Stores all data which make up a menu. Always created using the
 * Menu.MenuBuilder class.
 */
public class Menu {
	private String title, description;
	private Date date;
	private int hash;

	/**
	 * Creates a Menu from a given MenuBuilder. Is private to ensure that Menus
	 * are only created by using the build() method from the MenuBuilder class.
	 * 
	 * @param builder
	 *            MenuBuilder containing all information to instantiate a Menu.
	 *            Must not be null;
	 */
	private Menu(MenuBuilder builder) {
		this.title = builder.title;
		this.description = builder.description;
		this.date = builder.date;
		this.hash = builder.hash;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Date getDate() {
		return date;
	}

	public int getHash() {
		return hash;
	}

	/**
	 * Converts the date when the menu is served to a string. This string
	 * depends on the Locale settings and should only be used for visual output.
	 * 
	 * @return String containing the date of the menu in a long format (e.g.
	 *         "Monday, 14. October 2013").
	 */
	public String getDateString() {
		return new SimpleDateFormat("EEEE, dd. MMMM yyyy", Locale.getDefault()).format(date);
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other instanceof Menu) {
			Menu otherMenu = (Menu) other;
			if (otherMenu.getHash() != this.hash)
				return false;
			if (!otherMenu.getDate().equals(this.date))
				return false;
			if (!otherMenu.getTitle().equals(this.title))
				return false;
			if (!otherMenu.getDescription().equals(this.description))
				return false;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Menu " + hash + " { \n" + "  Title: " + title + "\n  Description: " + description + "\n  Date: "
				+ getDateString() + " \n }";
	}

	/**
	 * Standard builder class used to construct Menu objects.
	 */
	public static class MenuBuilder {
		private String title, description;
		private Date date;
		private int hash;

		public MenuBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public MenuBuilder setDescription(String description) {
			this.description = description;
			return this;
		}

		public MenuBuilder setDate(Date date) {
			this.date = date;
			return this;
		}

		public MenuBuilder setHash(int hash) {
			this.hash = hash;
			return this;
		}

		public Menu build() {
			return new Menu(this);
		}
	}
}
