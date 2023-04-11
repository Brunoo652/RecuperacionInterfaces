import gi
gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from first_window import FirstWindow
from load_window import LoadWindow

win = FirstWindow()
win.show_all()

Gtk.main()
