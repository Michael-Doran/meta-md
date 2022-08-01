SUMMARY = "Initial boot script"
DESCRIPTION = "Script to demonstrate switch root at startup with an initramfs"
LICENSE = "CLOSED"
PR = "r3"
RDEPENDS_${PN} += "bash"
SRC_URI =  " \
    file://init.sh \
"

FILES_${PN} += "/*"


do_compile () {
}

do_install () {
    install -d ${D}/
    install -m 0755 ${WORKDIR}/init.sh ${D}/init
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"

inherit allarch systemd