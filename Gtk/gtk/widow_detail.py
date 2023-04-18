import gi
from gi.overrides.GdkPixbuf import GdkPixbuf

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk


class WindowDetail(Gtk.Window):
    flowbox = Gtk.FlowBox()

    def __init__(self, image, descripcion, name):
        super().__init__()
        self.name = name
        self.descripcion = descripcion
        self.connect("destroy", Gtk.main_quit)
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

        imagenNueva = Gtk.Image()
        imagenNueva.set_from_pixbuf(image.get_pixbuf())

        box.pack_start(Gtk.Label(label=self.name), False, False, 0)

        box.pack_start(imagenNueva, False, False, 0)

        box.pack_start(Gtk.Label(label=self.descripcion), False, False, 0)

