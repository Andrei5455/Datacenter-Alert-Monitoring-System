package org.example;

public class Server {
    private String ipAddress;
    private Location location;
    private User owner;

    private String hostName;
    private ServerStatus status;
    private Integer cpuCores;
    private Integer ramGb;
    private Integer storageGb;

    private Server (Builder builder) {
        this.ipAddress = builder.ipAddress;
        this.location = builder.location;
        this.owner = builder.owner;
        this.hostName = builder.hostName;
        this.status = builder.status;
        this.cpuCores = builder.cpuCores;
        this.ramGb = builder.ramGb;
        this.storageGb = builder.storageGb;
    }

    public static class Builder {
        private String ipAddress;
        private Location location;
        private User owner;

        private String hostName;
        private ServerStatus status;
        private Integer cpuCores;
        private Integer ramGb;
        private Integer storageGb;

        public Builder(String ipAddress, Location location, User owner) {
            if (ipAddress.isBlank())
                throw new MissingIpAddressException("ADD SERVER: MissingIpAddressException: Server IP Address was not provided.");
            else
                this.ipAddress = ipAddress;
            this.location = location;
            this.owner = owner;
        }
        public Builder setHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }
        public Builder setStatus(ServerStatus status) {
            this.status = status;
            return this;
        }
        public Builder setCpuCores(String cpuCores) {
            if (cpuCores.isBlank())
                this.cpuCores = null;
            else
                this.cpuCores = Integer.parseInt(cpuCores.trim());
            return this;
        }
        public Builder setRamGb(String ramGb) {
            if (ramGb.isBlank())
                this.ramGb = null;
            else
                this.ramGb = Integer.parseInt(ramGb.trim());
            return this;
        }
        public Builder setStorageGb(String storageGb) {
            if (storageGb.isBlank())
                this.storageGb = null;
            else
                this.storageGb = Integer.parseInt(storageGb.trim());
            return this;
        }
        public Server build() {
            return new Server(this);
        }
    }
}
