import gi
from gi.overrides.GdkPixbuf import GdkPixbuf

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk


class WindowDetail(Gtk.Window):
    flowbox = Gtk.FlowBox()

    def __init__(self, imagenNueva, descripcion, name):
        super().__init__()
        self.name = name
        self.descripcion = descripcion
      #  self.connect("destroy", Gtk.main_quit)
        self.set_border_width(15)
        self.set_default_size(400, 400)

        header = Gtk.HeaderBar(title="Detalle del videojuego")
        header.props.show_close_button = True

        self.set_titlebar(header)

        scrolled = Gtk.ScrolledWindow()
        scrolled.set_policy(Gtk.PolicyType.NEVER, Gtk.PolicyType.AUTOMATIC)
        scrolled.add(self.flowbox)
        self.add(scrolled)

        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=10)
        self.flowbox.add(box)

        box.pack_start(Gtk.Label(label=self.name), False, False, 0)

        box.pack_start(imagenNueva, False, False, 0)

        self.textview = Gtk.TextView()
        self.textbuffer = self.textview.get_buffer()
        self.textbuffer.set_text(self.descripcion)
        self.textview.set_wrap_mode(Gtk.WrapMode.WORD_CHAR)

        box.pack_start(self.textview, False, False, 0)
